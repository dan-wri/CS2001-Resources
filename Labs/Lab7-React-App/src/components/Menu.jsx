import { Link } from 'react-router-dom'

export default function Menu(){
    return (
        <nav>
            <ul className='navlist'>
                <li><Link to='/'>Home</Link></li>
                <li><Link to='register'>Register</Link></li>
                <li><Link to='login'>Login</Link></li>
                <li><Link to='help'>Help</Link></li>
                <li><Link to='delete'>Delete</Link></li>
            </ul>
        </nav>
    )
}