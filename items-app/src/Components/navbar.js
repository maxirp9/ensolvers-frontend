import React from 'react'
import {NavLink} from 'react-router-dom'

export default function Navbar() {
    return (
        <div>
            <ul>
                <li>
                    <NavLink to='/'>Home</NavLink>
                </li>
                <li>
                    <NavLink to='/dashboard'>Dashboard</NavLink>
                </li>
                <li>
                    <NavLink to='/tasks'>tasks</NavLink>
                </li>
                <li>
                    <NavLink to='/folders'>folders</NavLink>
                </li>
            </ul>
        </div>
    )
}
