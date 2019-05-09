import React from "react";
import client from "../client";


export default class PetList extends React.Component {
    constructor(props) {
        super(props);
        this.state = {pets: []};

        this.petAdded = this.petAdded.bind(this);
    }

    componentDidMount() {
        client({method: 'GET', path: '/petclinic/pets'}).done(response => {
            this.setState({pets: response.entity._embedded.pets});
        });
    }

    petAdded( newPet ) {
        this.setState({pets: [...this.state.pets, newPet]});
    }


    render() {
        const pets = this.state.pets.map(pet =>
            <Pet key={pet._links.self.href} pet={pet}/>
        );
        return (
            <div>
                <table>
                    <tbody>
                        <tr>
                            <th>First Name</th>
                            <th>Last Name</th>
                        </tr>
                        {pets}
                    </tbody>
                </table>
                <AddPet petAdded={this.petAdded}/>
            </div>
        )
    }
}

const Pet = (props) => (
    <tr>
        <td> {props.pet.firstName}</td>
        <td> {props.pet.lastName}</td>
    </tr>
);

class AddPet extends React.Component {
    constructor(props) {
        super(props);
        this.state={
            firstName: "",
            lastName: ""
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(e){
        e.preventDefault();
        this.setState({ [e.target.id]: e.target.value});
    }

    handleSubmit(e) {
        e.preventDefault();
        let { firstName, lastName } = this.state;
        let newPet = {
            firstName: firstName,
            lastName: lastName
        };
        client({
            method: 'POST',
            path: '/petclinic/pets',
            entity: newPet,
            headers: {'Content-Type': 'application/json'}
            }).done(response => {
                if ( response.status.code === 201) //CREATED
                    this.props.petAdded( response.entity );
        });
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <label htmlFor="firstName">
                    First Name:
                    <input type={"text"} value={this.state.firstName} onChange={this.handleChange} name={"firstName"} id={"firstName"}/>
                </label>
                <label htmlFor="lastName">
                    Last Name:
                    <input type={"text"} value={this.state.lastName} onChange={this.handleChange} name={"lastName"} id={"lastName"} />
                </label>
                <input type={"submit"} value={"Submit"}/>
            </form>
        )
    }
}

