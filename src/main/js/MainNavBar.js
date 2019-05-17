import React from "react";
import {BrowserRouter as  Router, Route, Link} from "react-router-dom"
import PetList from "./Pets/PetList";
import VetList from "./Vets/VetList";
import AppointmentCreate from "./Appointment/AppointmentCreate";
import MenuList from "@material-ui/core/MenuList";
import MenuItem from "@material-ui/core/MenuItem";

export default class MainNavBar extends React.Component {
    render() {
        return(
            <MenuList>
                <MenuItem>
                    <Link to={"/Vets"} style={{textDecoration: 'none'}} >Vets</Link>
                </MenuItem>
                <MenuItem>
                    <Link to={"/Pets"} style={{textDecoration: 'none'}} >Pets </Link>
                </MenuItem>
                <MenuItem>
                    <Link to={"/Appointments"} style={{textDecoration: 'none'}}>Appointments</Link>
                </MenuItem>

                <Route path={"/Vets"} component={VetList}/>
                <Route path={"/Pets"} component={PetList}/>
                <Route path={"/Appointments"} component={AppointmentCreate}/>
            </MenuList>
        )
    }
}