package com.sam.mongodb.controller;

import com.sam.mongodb.model.Task;
import com.sam.mongodb.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task")
@CrossOrigin("http://localhost:3000")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task addTask(@RequestBody Task task){

        return taskService.addTask(task);
    }
    @GetMapping
    public List<Task> getTasks(){
        return taskService.getAllTask();
    }

    @GetMapping("/{taskId}")
    public Optional<Task> getTaskById(@PathVariable String taskId){
        return taskService.getTaskById(taskId);
    }

    @GetMapping("/severity/{severity}")
    public List<Task> getTaskBySeverity(@PathVariable int severity){
        return taskService.getTasksBySeverity(severity);
    }

    @GetMapping("/assignee/{assignee}")
    public List<Task> getTaskBySeverity(@PathVariable String assignee){
        return taskService.getTasksByAssignee(assignee);
    }
    @PutMapping
    public Task updateTask(@RequestBody Task task){

        return taskService.updateTask(task);
    }
    @DeleteMapping("/{taskid}")
    public String deleteByTaskId(@PathVariable String taskid){
        return taskService.delete(taskid);
    }
}
