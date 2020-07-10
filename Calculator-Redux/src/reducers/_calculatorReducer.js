const CalculatorReducer = (state = "", action) => {
    switch (action.type) {
        case "=":
            try {
                var val = eval(state);
            }
            catch (err) {
                var val = "error";
            }
            return val+"";
        case "AC":
            var val = [...state];
            val = "";
            return val;
        case "<=":
            var val = state;
            return val.substring(0, val.length - 1)
        
        case "1":
        case "2":
        case "3":
        case "4":
        case "5":
        case "6":
        case "7":
        case "8":
        case "9":
        case "0":
        case "+":
        case "-":
        case "/":
        case "*":
        case ".":
            var val=state + action.value;
            return val;
        
        default: 
            return state;
        
    }
} 

export default CalculatorReducer;