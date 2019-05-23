import React from "react";
import ReactDOM from "react-dom";
import {BrowserRouter as Router, Link} from "react-router-dom"
import NavBar from "./NavBar";
import Button from '@material-ui/core/Button';
import 'typeface-roboto';

class App extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
                <Router>
                    <NavBar/>
                    <Link to={"/Appointments"}>
                    <Button variant={"contained"} color={"primary"}>
                        Schedule an Appointment
                    </Button>
                        </Link>
                </Router>
            </div>
        )
    }
}

/*
const Button = (props) => (
    <button className={"btn btn-default " + props.className} onClick={props.onClick || function (evt) {
        console.log("event received" + evt.target)
    }}>
        {props.children}
    </button>
);

const PrimaryButton = (props) => (
    <Button className="btn-primary" onClick={props.onClick}>
        {props.children}
    </Button>
);

 */

ReactDOM.render(
    <App/>,
    document.getElementById("react")
);