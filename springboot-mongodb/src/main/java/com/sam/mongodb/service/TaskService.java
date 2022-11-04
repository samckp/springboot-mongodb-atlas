package com.sam.mongodb.service;

import com.sam.mongodb.model.Task;
import com.sam.mongodb.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public Task addTask(Task task){

        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        return taskRepository.save(task);
    }
    public List<Task> getAllTask(){

        return taskRepository.findAll();
    }
    public Optional<Task> getTaskById(String taskId){

        return taskRepository.findById(taskId);
    }
    public List<Task> getTasksBySeverity(int severity){

        return taskRepository.findBySeverity(severity);
    }
    public List<Task> getTasksByAssignee(String assignee){

        return taskRepository.getTasksByAssignee(assignee);
    }
    public Task updateTask(Task task){

        Task existingTask = taskRepository.findById(task.getTaskId()).orElse(new Task());
        existingTask.setDescription(task.getDescription());
        existingTask.setAssignee(task.getAssignee());
        existingTask.setSeverity(task.getSeverity());
        existingTask.setStoryPoint(task.getStoryPoint());

        return taskRepository.save(existingTask);
    }

    public String delete(String taskId){

        taskRepository.deleteById(taskId);
        return taskId + " task deleted !!";
    }
}
