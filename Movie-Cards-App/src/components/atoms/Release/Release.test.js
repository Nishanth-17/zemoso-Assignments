import React from 'react';
import {create} from 'react-test-renderer'
import "@testing-library/jest-dom/extend-expect";
import Release from './Release'

test("Match the snapshot - Release",() => {
    const input=create(<Release />);
    expect(input.toJSON()).toMatchSnapshot();
})