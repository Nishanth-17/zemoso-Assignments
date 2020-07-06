import React from 'react';
import {create} from 'react-test-renderer'
import "@testing-library/jest-dom/extend-expect";
import Rating from './Rating'

test("Match the snapshot - Rating",() => {
    const input=create(<Rating />);
    expect(input.toJSON()).toMatchSnapshot();
})