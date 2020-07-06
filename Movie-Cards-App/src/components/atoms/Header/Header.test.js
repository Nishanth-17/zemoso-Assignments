import React from 'react';
import {create} from 'react-test-renderer'
import "@testing-library/jest-dom/extend-expect";
import Header from './Header'

test("Match the snapshot - Header",() => {
    const input=create(<Header />);
    expect(input.toJSON()).toMatchSnapshot();
})