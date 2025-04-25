import {useEffect, useState} from 'react'
import './App.css'
import {UserCard} from "./components/UserCard.tsx";
import axios from "axios";
import {Button} from "react-bootstrap";

function App() {
  const [contacts, setContacts] = useState([]);

  const refreshData = () => {
      const baseURL = "http://localhost:8080"
      const endpoint = "api/usercard";
      axios.get(`${baseURL}/${endpoint}`)
          .then((r) => {
              // console.log(r.data)
              setContacts(r.data)
          })
  }

  const postData = () => {
      const baseURL = "http://localhost:8080"
      const endpoint = "api/usercard";
      axios.post(`${baseURL}/${endpoint}`, {
              name: "New Card",
              address: "",
              city: "",
              state: "",
              email: "",
              phone: "",
              imgLink: ""
          },
          {headers: {'Content-Type': "application/json"}})
          .then((r) => {
              refreshData()
              console.log(r.data)
          })
          .catch((error) => {
              console.log(error);
          })
  }

    useEffect(() => {
    // On page load
    refreshData();
    }, []);

  return (
    <>
      <h1>Home page</h1>
        <Button onClick={postData}>Add Data</Button>
        <div className="d-flex flex-row flex-wrap justify-content-center" id="ContactPageCardsWrapper">
            {contacts.map((contact) => (
                <UserCard key={contact.id} name={contact.name} cardInfo={contact} />
            ))}
        </div>
        </>
  )
}

export default App
