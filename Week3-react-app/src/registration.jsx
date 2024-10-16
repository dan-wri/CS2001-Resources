import { useRef } from 'react';

function Registration() {
    const nameRef = useRef();
    const emailRef = useRef();
    const passwordRef = useRef();
    const repPasswordRef = useRef();
    const buyerRef = useRef();
    const sellerRef = useRef();
    const tosRef = useRef();

    const handleSubmit = (event) => {
        event.preventDefault();
        const name = nameRef.current.value;
        const email = emailRef.current.value;
        const password = passwordRef.current.value;
        const repPassword = repPasswordRef.current.value;
        const buyer = buyerRef.current.checked;
        const seller = sellerRef.current.checked;
        const tos = tosRef.current.checked;

        console.log({
            name,
            email,
            password,
            repPassword,
            buyer,
            seller,
            tos,
        });
    };

    return (
        <form className="center" onSubmit={handleSubmit} noValidate>
            <label className="textInput" htmlFor="name">Name:</label>
            <input type="text" id="name" name="name" required maxLength="50" ref={nameRef} /><br /><br />

            <label className="textInput" htmlFor="email">Email:</label>
            <input type="email" id="email" name="email" required ref={emailRef} /><br /><br />

            <label className="textInput" htmlFor="password">Password:</label>
            <input type="password" id="password" name="password" required minLength="8" ref={passwordRef} /><br /><br />

            <label className="textInput" htmlFor="repPassword">Re-type password:</label>
            <input type="password" id="repPassword" name="repPassword" required minLength="8" ref={repPasswordRef} /><br /><br />

            <input type="checkbox" id="buyer" name="buyer" value="buyer" ref={buyerRef} />
            <label htmlFor="buyer">I want to buy produce directly from allotment owners.</label><br />
            <input type="checkbox" id="seller" name="seller" value="seller" ref={sellerRef} />
            <label htmlFor="seller">I want to sell produce from my allotment.</label><br /><br />

            <input type="checkbox" id="tos" name="tos" value="tos" required ref={tosRef} />
            <label htmlFor="tos">I agree to the <a href="">Terms of Use</a> and <a href="">Privacy Policy</a>.</label>
            <br /><br />
            <input type="submit" id="button" value="Register" />
            <a href="">Learn more</a>
        </form>
    );
}

export default Registration;
