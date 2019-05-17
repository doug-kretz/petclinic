import React from "react";
import ReactDOM from "react-dom";
import {BrowserRouter as Router, Link} from "react-router-dom";
import MainNavBar from "./MainNavBar";
import "typeface-roboto";
class App extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
                <Router>
                    <MainNavBar/>
                    <Link to={"/Appointments"}>
                    <PrimaryButton>
                        Schedule an Appointment
                    </PrimaryButton>
                        </Link>
                </Router>
            </div>
        )
    }
}


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

ReactDOM.render(
    <App/>,
    document.getElementById("react")
);