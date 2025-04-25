import {Button, Form} from "react-bootstrap";
import {useState} from "react";
import axios from "axios";

type props = {
    myId: any,
    refreshData: () => void
}

export default function UserForm({myId, refreshData}: props) {
    const states = ["AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "IA",
        "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO",
        "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK",
        "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI",
        "WV", "WY"]

    const [data, setData] = useState({
        name: null,
        address: null,
        city: null,
        state: null,
        email: null,
        phone: null,
        imgLink: null
    })

    const handleSubmit = (event: any) => {
        event.preventDefault();
        console.log("Submit attempt", data)
        const baseURL = "http://localhost:8080"
        const endpoint = `api/usercard/${myId}`;

        axios.patch(`${baseURL}/${endpoint}`, {
                name: data.name,
                address: data.address,
                city: data.city,
                state: data.state,
                email: data.email,
                phone: data.phone,
                imgLink: data.imgLink
        },
            {headers: {'Content-Type': "application/json"}})
            .then((r) => {
                console.log(r.data)
                refreshData();
            })
            .catch((error) => {
                console.log(error);
            })

    }

    const handleChange = (event: any) => {
        const {name, value} = event.target

        // console.log(name, value)
        setData((prev) => ({
            ...prev,
            [name]: value,
        }));
        // console.log("Data:", data)
    }

    const handleDelete = (event: any) => {
        event.preventDefault();
        console.log("Delete attempt", data)
        const baseURL = "http://localhost:8080"
        const endpoint = `api/usercard/${myId}`;

        axios.delete(`${baseURL}/${endpoint}`)
            .then((r) => {
                console.log(r.data)
                refreshData();
            })
            .catch((error) => {
                console.log(error);
            })

    }

    return (
        <Form title={"userForm"} className={"userForm"} onSubmit={handleSubmit}>
            <Form.Group className="mb-3" controlId="formEmail">
                <Form.Label>Email address</Form.Label>
                <Form.Control
                    type="email"
                    name="email"
                    value={data.email}
                    onChange={handleChange}
                    placeholder="Enter email"
                />
            </Form.Group>


            <Form.Group className="mb-3" controlId="name">
                <Form.Label>Name</Form.Label>
                <Form.Control type="text" placeholder="Name" name="name" value={data.name} onChange={handleChange}/>
            </Form.Group>

            <Form.Group className="mb-3" controlId="address">
                <Form.Label>Address</Form.Label>
                <Form.Control type="text" placeholder="Address" name="address" value={data.address} onChange={handleChange}/>
            </Form.Group>

            <Form.Group className="mb-3" controlId="city">
                <Form.Label>City</Form.Label>
                <Form.Control type="text" placeholder="City" name="city" value={data.city} onChange={handleChange}/>
            </Form.Group>

            <Form.Group className="mb-3" controlId="state" >
                <Form.Label>State</Form.Label>
                <Form.Select name="state" value={data.state} onChange={handleChange}>
                    <option>Select your state</option>
                    {states.map((states, index) => (
                        <option key={index}>{states}</option>
                    ))}
                </Form.Select>
            </Form.Group>

            <Form.Group className="mb-3" controlId="phone">
                <Form.Label>Phone number</Form.Label>
                <Form.Control type="text" placeholder="XXX-XXX-XXXX" name="phone" value={data.phone} onChange={handleChange}/>
            </Form.Group>

            <Button id={"submitButton"} variant="primary" type="submit">
                Update
            </Button>
            <Button id={"deleteButton"} variant="danger" onClick={handleDelete}>
                Delete
            </Button>
        </Form>
    )
}