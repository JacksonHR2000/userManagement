import {Button, Form} from "react-bootstrap";

export default function UserForm() {
    const states = ["AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "IA",
        "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO",
        "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK",
        "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI",
        "WV", "WY"]

    return (
        <Form title={"userForm"} className={"userForm"}>
            <Form.Group className="mb-3" controlId="formBasicEmail">
                <Form.Label>Email address</Form.Label>
                <Form.Control type="email" placeholder="name@email.com" disabled={true}/>
                <Form.Text className="text-muted">
                    Your email address cannot be changed.
                </Form.Text>
            </Form.Group>

            <Form.Group className="mb-3" controlId="formBasicPassword">
                <Form.Label>Name</Form.Label>
                <Form.Control type="text" placeholder="Name" />
            </Form.Group>

            <Form.Group className="mb-3" controlId="formBasicPassword">
                <Form.Label>Address</Form.Label>
                <Form.Control type="text" placeholder="Address" />
            </Form.Group>

            <Form.Group className="mb-3" controlId="formBasicPassword">
                <Form.Label>City</Form.Label>
                <Form.Control type="text" placeholder="City" />
            </Form.Group>

            <Form.Group className="mb-3" controlId="formBasicPassword">
                <Form.Label>State</Form.Label>
                <Form.Select>
                    <option>Select your state</option>
                    {states.map((states, index) => (
                        <option key={index}>{states}</option>
                    ))}
                </Form.Select>
            </Form.Group>

            <Form.Group className="mb-3" controlId="formBasicPassword">
                <Form.Label>Phone number</Form.Label>
                <Form.Control type="text" placeholder="XXX-XXX-XXXX" />
            </Form.Group>

            <Button id={"submitButton"} variant="primary" type="submit">
                Update
            </Button>
        </Form>
    )
}