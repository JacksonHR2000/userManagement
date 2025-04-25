import {useState} from "react";
import {Card, Button} from "react-bootstrap";
import 'bootstrap/dist/css/bootstrap.min.css';
import UserForm from "./UserForm.tsx";
// @ts-ignore
import UserInfo from "./UserInfo.tsx";
import defaultUser from "../assets/defaultUser.png"

type props = {
    cardInfo: UserInfo,
    refreshData: () => void
}

export const UserCard = ({cardInfo, refreshData}:props) => {

    const [formBool, setFormBool] = useState(false);

    return (
        <>
            <Card style={{ width: '18rem' }}>
                <h2>{cardInfo.name}</h2>
                <Card.Img variant="top" src={cardInfo.imgLink == "" ? defaultUser : "null"} />
                <p>Address: {cardInfo.address}</p>
                <p>City: {cardInfo.city}</p>
                <p>State: {cardInfo.state}</p>
                <p>Email: {cardInfo.email}</p>
                <p>Phone: {cardInfo.phone}</p>

                <Button onClick={ () => setFormBool(!formBool)}>Update info</Button>
                <Card.Body>
                    {formBool ? <UserForm refreshData={refreshData} myId={cardInfo.id}/> : null}
                </Card.Body>
            </Card>
        </>
    )
}