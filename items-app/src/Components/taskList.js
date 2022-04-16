import React from 'react'; 
import {useState,useEffect } from 'react';
import { Container, CommentActions } from 'semantic-ui-react';
import { Button, Card, Image, List, Checkbox } from 'semantic-ui-react'
import axios from 'axios';
import { useNavigate, Link , Outlet } from 'react-router-dom'

function TaskList(){
    const [task, setTask] = useState();
    const [taskList, setTaskList] = useState([]);
    const navigate = useNavigate();
    

    function getTaskList (){
        axios.get('http://localhost:8080/task')
        .then((response) => response.data)
        .then(response => setTaskList(response));
    }

    useEffect(() => {
        getTaskList();        
    },[taskList]);

    function onEditClick (taskid) {
        console.log('inside edit'+taskid);        
        navigate("/tasks/"+taskid);    
       
    }

    function onDeleteClick (taskid) {
        console.log('inside delete');

        axios.delete(`http://localhost:8080/task/${taskid}`);
    }

    function onSubmitClick () {
        console.log('inside submit');
        
        axios.post('http://localhost:8080/task', {
            name: task
          })
          .then(function (response) {
            console.log(response);
          })
          .catch(function (error) {
            console.log(error);
          });

          setTask('')
    }

    return(
        <div>
             <Container>                
                
                <div>
                    <h3> To do List </h3>
                    <List>
                        {taskList.map((task)=>(
                            <List.Item key={task.id}>                           

                                    <Checkbox label='' />
                                    <b>{task.name}</b>
                                    <Button content='Edit' onClick={()=>onEditClick(task.id)} /> 
                                    <Button content='Delete' onClick={()=>onDeleteClick(task.id)} />                           
                                    
                                
                            </List.Item>  
                         ))}                      
                    </List> 
                    <div className="ui input">
                    <input value={task} placeholder="your task" onChange={(e) => setTask(e.target.value)} />
                      </div>            
                     <button type="submit" className="ui primary button basic" onClick={()=>onSubmitClick()}>Add</button>       
                </div>                

            </Container>
        </div>
    )
}

export default TaskList;