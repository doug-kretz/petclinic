import React from "react";
import {BrowserRouter as Router, Route, Link} from "react-router-dom"
import PetList from "./Pets/PetList";
import VetList from "./Vets/VetList";
import AppointmentCreate from "./Appointment/AppointmentCreate";

export default class NavBar extends React.Component {
    render() {
        return (
            <Router>
                <div>
                    <nav className={"mainNav"}>
                        <Link to={"/Vets"} style={{ textDecoration: 'none' }} className={"mainNavLink"}>Vets</Link>
                        <Link to={"/Pets"} style={{ textDecoration: 'none' }} className={"mainNavLink"}>Pets </Link>
                        <Link to={"/Appointments"} style={{ textDecoration: 'none' }} className={"mainNavLink"}>Appointments</Link>
                    </nav>
                </div>

                <Route path={"/Vets"} component={VetList}/>
                <Route path={"/Pets"} component={PetList}/>
                <Route path={"/Appointments"} component={AppointmentCreate}/>
            </Router>
        )
    }
}