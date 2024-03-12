package io.warehouse13.learning;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // challenge part 1:
        // You'll want to create a class that represents a Task.
        // It should have
        // > an assignee.
        // > a project name.
        // > a task description.
        // > a status (assigned, in progress, or not yet assigned).
        // > a priority, High, Low, or Medium.
        // Each of these attributes should be editable.
        //
        // A task is uniquely identified by its project name and description.
        // The task should implement Comparable, so that tasks are sorted by project name and description.
        //
        // The TaskData class will be used to set up, and return some test data.
        //If you want to use my data, it can be found in a csv file in the resources folder of this section, and
        // consists of the following:
        //
        // > All tasks identified by the manager.
        // > Tasks identified by Ann, that she's working on or plans to work on.
        // > Tasks which Bob says have been assigned to him.
        // > Tasks Carol is doing, as reported by herself.
        // This class should have a getData method, that returns a Set of Task.   This method should take a String,
        // either the name of one of the employees to get a specific set, or 'all' to get the full task set.


        // challenge part 2:
        // Let's say you're a new manager, of a team that consists of three team members working under you, Ann, Bob,
        // and Carol.
        // Each of these developers is working on a set of tasks.
        // You've asked all your developers to submit what they're working on to you.
        // You also have a master set of tasks, which your own boss sent to you.
        // You'll be using that data, to answer the following questions.
        // > What is the full task list? This is the list of all tasks described by your manager or boss, and any additional tasks the employees have, that may not be on that list.
        // > Which tasks are assigned to at least one of your 3 team members?
        // > Which tasks still need to be assigned?
        // > Which tasks are assigned to multiple employees?
        // To do some of this work, create three methods on your Main class.
        // Be sure the sets you pass to these methods, don't mutate in these methods.   In other words, return a new set.
        // > Create a getUnion method, that takes a List of Sets, and will return the union of all the sets.
        // > Create a getIntersect method, that takes two Sets, and returns the intersection of the sets.
        // > Create a getDifference method, that takes two Sets, and removes the second argument's set from the first.


        Set<Task> tasks = TaskData.getTasks("all");
        sortAndPrint("All Tasks", tasks);

        Comparator<Task> sortByPriority = Comparator.comparing(Task::getPriority);
        Set<Task> annTasks = TaskData.getTasks("Ann");
        sortAndPrint("Ann Tasks", annTasks, sortByPriority);

        Set<Task> bobTasks = TaskData.getTasks("bob");
        sortAndPrint("Bob Tasks", bobTasks, sortByPriority.reversed());

        Set<Task> carolTasks = TaskData.getTasks("carol");
        sortAndPrint("Carole Tasks", carolTasks);

        // union of all tasks
        List<Set<Task>> sets = List.of(annTasks, bobTasks, carolTasks);

        Set<Task> assignedTasks = getUnion(sets);
        sortAndPrint("All assigned tasks", assignedTasks);

        Set<Task> everyTasks = getUnion(List.of(tasks, assignedTasks));
        sortAndPrint("True all tasks", everyTasks);

        Set<Task> missingTasks = getDifference(everyTasks, tasks);
        sortAndPrint("Missing tasks", missingTasks);

        // get unassigned tasks
        Set<Task> unassignedTasks = getDifference(tasks, assignedTasks);
        sortAndPrint("Unassigned tasks", unassignedTasks, sortByPriority);

        // overlapped tasks: task assigned to more than 1 person
        Set<Task> overlap = getUnion(List.of(
                getIntersect(annTasks, bobTasks),
                getIntersect(annTasks, carolTasks),
                getIntersect(bobTasks, carolTasks)));

        sortAndPrint("Assigned to multiples", overlap, sortByPriority);

        List<Task> overlapping = new ArrayList<>();
        for(Set<Task> set: sets) {
            Set<Task> dupes = getIntersect(set, overlap);
            overlapping.addAll(dupes);
        }

        Comparator<Task> priorityNatural = sortByPriority
                .thenComparing(Comparator.naturalOrder());
        sortAndPrint("Overlapping", overlapping, priorityNatural);
    }

    private static void sortAndPrint(
            String header,
            Collection<Task> collection) {
        sortAndPrint(header, collection, null);
    }

    private static void sortAndPrint(
            String header,
            Collection<Task> collection,
            Comparator<Task> sorter) {
        String lineSeparator = "-".repeat(90);
        System.out.println(lineSeparator);
        System.out.println(header);
        System.out.println(lineSeparator);
        List<Task> list = new ArrayList<>(collection);
        list.sort(sorter);
        list.forEach(System.out::println);
    }

    private static Set<Task> getUnion(List<Set<Task>> tasksSet) {
        Set<Task>  unions = new HashSet<>();
        tasksSet.forEach(unions::addAll);
        return unions;
    }

    private static Set<Task> getIntersect(Set<Task> a, Set<Task> b) {
        Set<Task> intersect = new HashSet<>(a);
        intersect.retainAll(b);
        return intersect;
    }

    private static Set<Task> getDifference(Set<Task> a, Set<Task> b) {
        Set<Task> diff = new HashSet<>(a);
        diff.removeAll(b);
        return diff;

    }
}
