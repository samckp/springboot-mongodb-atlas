import axios from 'axios';
import React, { useEffect, useState } from 'react'

export default function Home() {

const [tasks, setTask]= useState([]);

useEffect(() => {
    loadTasks();
}, []);

const loadTasks=async()=>{
        const result=await axios.get("http://localhost:8080/task");
        console.log(result.data);
        setTask(result.data);
};

    

return (
    <div className="container">
      <div className="py-4">
        <table class="table border">
          <thead>
            <tr class="table-primary">
              <th scope="col">#</th>
              <th scope="col">TaskId</th>
              <th scope="col">Description</th>
              <th scope="col">Assignee</th>
              <th scope="col">Severity</th>
              <th scope="col">StoryPoint</th>
              <th scope="col">Action</th>
            </tr>
          </thead>
          <tbody>
                    {
                        tasks.map((task, index) =>(
                             <tr>
                             <th scope="row" key={index}>{index+1}</th>
                             <td>{task.taskId}</td>
                             <td>{task.description}</td>
                             <td>{task.assignee}</td>
                             <td>{task.severity}</td>
                             <td>{task.storyPoint}</td>

                             <td>
                                <button className="btn btn-primary mx-2">View</button>
                                <button className="btn btn-outline-primary mx-2">Edit</button>
                                <button className="btn btn-danger mx-2">Delete</button>
                             </td>
                           </tr>
                    ))
                    };
           
            
          </tbody>
        </table>
      </div>
    </div>
  );
}