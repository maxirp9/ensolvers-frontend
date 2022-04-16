import React from 'react'; 
import {useState,useEffect } from 'react';
import { Button, Card, Image, List, Checkbox } from 'semantic-ui-react'
import axios from 'axios';
import {useParams,useNavigate} from 'react-router-dom'

function TaskEdit(){

    const {id} = useParams()

    const [taskEdit, setTaskEdit] = useState(false);
    const [taskName, setTaskName] = useState('');

    const navigate = useNavigate();

    function getTaskEdit (){
        axios.get(`http://localhost:8080/task/${id}`)
        .then((response) => response.data)
        .then(respose => setTaskEdit(respose));
        
    }

    
        useEffect(() => {    
            getTaskEdit();
            setTaskName(taskEdit.name);               
        
        },[]);
    
    
    
    
    
    function onSaveClick () {
        console.log('inside edit');
        
        axios.put(`http://localhost:8080/task/${id}`, {
            name: task
            
          })
          .then(function (response) {
            console.log(response);
          })
          .catch(function (error) {
            console.log(error);
          });

          navigate("/tasks");
    }

    const [task, setTask] = useState('');

    const cancelClick = () => {
        navigate("/tasks");
    }

    return(
        <div>
            
            <h3>Task Edit</h3>
            <div className="ui input">
                    <input value={task} placeholder={taskEdit.name} onChange={(e) => setTask(e.target.value)} />
            </div>
            <Button content='Save' onClick={()=>onSaveClick(id)}/> 
            <Button content='Cancel' onClick={cancelClick} />
        </div>
    )
}

export default TaskEdit;