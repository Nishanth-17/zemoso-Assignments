import React from 'react';
import {create} from 'react-test-renderer'
import "@testing-library/jest-dom/extend-expect";
import Title from './Title'

test("Match the snapshot - Title",() => {
    const input=create(<Title />);
    expect(input.toJSON()).toMatchSnapshot();
})