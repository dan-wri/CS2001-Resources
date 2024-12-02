import './App.css'

import { BrowserRouter, Route, Routes } from 'react-router-dom'

import Deletion from './components/Deletion'
import Help from './components/Help'
import Home from './components/Home'
import Layout from './components/Layout'
import Login from './components/Login'
import Registration from './components/Registration'

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route element={<Layout/>}>
          <Route index element={<Home/>}></Route>
          <Route path={'/register'} element={<Registration/>}></Route>
          <Route path={'/login'} element={<Login/>}></Route>
          <Route path={'/help'} element={<Help/>}></Route>
          <Route path={'/delete'} element={<Deletion/>}></Route>
        </Route>
      </Routes>
    </BrowserRouter>
  )
}

export default App
