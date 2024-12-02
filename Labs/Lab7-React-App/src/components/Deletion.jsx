import axios from "axios";
import {useRef} from "react";

export default function Deletion(){
    const id=useRef();

    const validateForm = () => {
        let formValid = false;

        if (id.current.validity.valueMissing){
                alert("Please fill in all text fields.");
        }
        else
        {
            formValid = true;
        }
        return formValid;
    }


    const handleSubmit = async (event) => {
        event.preventDefault();
    
        if (validateForm()) {
            try {
                const response = await axios.delete(`http://localhost:8080/user/${id.current.value}`);
    
                console.log(response);
    
                if (response.status === 204) {
                    alert(`User ${id.current.value} deleted successfully.`);
                }
                else
                {
                    alert("Something went wrong.");
                }
    
                // Clear input fields after successful registration
                id.current.value = "";
    
            } catch (error) {
                console.log(error);
                alert("Error deleting user, please check if the ID exists.")
            }
        }
    };
    

    return (
        <form className="deletion" noValidate>
            <label className="labelText">ID: </label>
            <input type="text" className="inputText" ref={id} name="id" required autoComplete="off"/><br/><br/>
            
            <button onClick={handleSubmit}>Submit</button>
        </form>
    )
}