import React from 'react';
import './App.css';
import Calculator from './_components/pages/_calculator'
import { ThemeProvider } from "@material-ui/core";
import { myTheme } from "./theme";


function App() {
  return (
    <ThemeProvider theme={myTheme}>
      <Calculator />
    </ThemeProvider>
  );
}

export default App;
