import logo from './logo.svg';
import './App.css';
import {useEffect, useState} from 'react';
import axios from 'axios';
import TaskList from './Components/taskList';
import TaskEdit from './Components/taskEdit';
import Home from './Components/home';
import UserPage from './Components/user';
import Dashboard from './Components/dashboard';
import NotFoundPage from './Components/notFoundPage';
import Navbar from './Components/navbar';
import { Button, Divider, Form, Grid, Segment } from 'semantic-ui-react';
import {
  BrowserRouter as Router,
  Routes,
  Route,
  Link
} from "react-router-dom";

function App() {
    
  return (
    <Router>
      <div className="App">

        <Navbar />
        <Routes>
          <Route path="/tasks" element={<TaskList/>} />
          <Route path="/tasks/:id" element={<TaskEdit/>} />
          <Route path="/users/:id" element={<UserPage/>} />
          <Route path="/dashboard/*" element={<Dashboard />}>
            <Route path='welcome' element={<p >Welcome!</p>} />
            <Route path='goodbye' element={<p >Goodbye!</p>} />
          </Route>
          <Route path="/" element={<Home/>} />
          <Route path="*" element={<NotFoundPage/>} />
          
        </Routes>
        
      
      </div>
    </Router>
  );
}

export default App;
