import React from 'react';
import ReactDOM from "react-dom";
import App from './components/pages/App'
import './index.js'

jest.mock("react-dom", () => ({ render: jest.fn() }));

  test("should render without crashing", () => {
    const div = document.createElement("div");
    div.id = 'root';
    document.body.appendChild(div);
    expect(ReactDOM.render).toHaveBeenCalledTimes(1);
  });
