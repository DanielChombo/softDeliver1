import { useState } from "react";

function Counter() {
    const [counter, setCounter] = useState(0);

    const aumentar = () => {
        setCounter(counter+1);
    }
    const diminuir = () => {
        setCounter(counter-1);
    }

    return (
        <div>
            <button onClick={aumentar}>Incrementar</button>
            <button onClick={diminuir}>Decrementar</button>
            <h3>Valor actual: {counter}</h3>
        </div>
    )
}

export default Counter;