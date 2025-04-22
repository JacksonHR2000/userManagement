import {useEffect, useState} from 'react'
import './App.css'
import {UserCard} from "./components/UserCard.tsx";

function App() {
  const [contacts, setContacts] = useState([{}]);

    useEffect(() => {
    // On page load
    setContacts([
        {
            email: "name@email.com",
            name: "First M. Last",
            address: "123 ABC St.",
            city: "Fakeville",
            state: "Ohio",
            phoneNum: "757-123-4567",
            imgLink: ""
    }])
    }, []);

  return (
    <>
      <h1>Home page</h1>
        <UserCard cardInfo={contacts[0]}/>
    </>
  )
}

export default App
