import React from 'react';
import {create} from 'react-test-renderer'
import "@testing-library/jest-dom/extend-expect";
import StarRating from './StarRating'

test("Match the snapshot - StarRating",() => {
    const input=create(<StarRating />);
    expect(input.toJSON()).toMatchSnapshot();
})