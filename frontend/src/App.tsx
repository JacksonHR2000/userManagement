import { useState } from 'react'
import './App.css'
import {UserCard} from "./components/UserCard.tsx";

function App() {
  // const [count, setCount] = useState(0)

  return (
    <>
      <h1>Home page</h1>
        <UserCard/>
    </>
  )
}

export default App
