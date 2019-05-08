const React = require("react");
const ReactDOM = require("react-dom");

class App extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
            <NavBar>
                <span> Vets </span>
                <span> Pets </span>
                <span> Appointments </span>
            </NavBar>
            <PrimaryButton>
                Schedule an Appointment
            </PrimaryButton>
            </div>
        )
    }
}


const Button = (props) => (
    <button className={"btn btn-default " + props.className} onClick={props.onClick || function(evt) {console.log("event received" + evt.target)}}>
        {props.children}
    </button>
);

const PrimaryButton = (props) => (
        <Button className="btn-primary" onClick={props.onClick}>
            {props.children}
        </Button>
);
const NavBar = (props) => (
    <div className="mainNav">
        {React.Children.map(props.children, child => (
            <NavLink> {child} </NavLink>
        ))}
    </div>
);

const NavLink = props => (
    <div className="mainNavLink">
        {props.children}
    </div>
);

ReactDOM.render(
    <App/>,
    document.getElementById("react")
);