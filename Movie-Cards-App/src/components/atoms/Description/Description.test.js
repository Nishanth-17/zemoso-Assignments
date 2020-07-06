import React from 'react';
import {create} from 'react-test-renderer'
import "@testing-library/jest-dom/extend-expect";
import Description from './Description'

test("Match the snapshot - Description",() => {
    const input=create(<Description/>);
    expect(input.toJSON()).toMatchSnapshot();
})