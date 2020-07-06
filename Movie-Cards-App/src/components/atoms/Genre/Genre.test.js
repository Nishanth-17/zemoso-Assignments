import React from 'react';
import {create} from 'react-test-renderer'
import "@testing-library/jest-dom/extend-expect";
import Genre from './Genre'

test("Match the snapshot - Genre",() => {
    const input=create(<Genre />);
    expect(input.toJSON()).toMatchSnapshot();
})