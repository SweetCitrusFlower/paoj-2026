package com.pao.laboratory03.bonus;

public class Task {
    private final String id;
    private final String title;
    private final Status status;
    private final Priority priority;
    private final String assignee;

    public Task(String id, String title, Status status, Priority priority, String assignee)
    {
        this.id = id;
        this.title = title;
        this.status = status;
        this.priority = priority;
        this.assignee = assignee;
    }

    public String getId(){return id;}
    public String getTitle(){return title;}
    public Status getStatus(){return status;}
    public Priority getPriority(){return priority;}
    public String getAssignee(){return assignee;}
    
}
