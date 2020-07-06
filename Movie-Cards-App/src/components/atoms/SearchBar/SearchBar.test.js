import React from 'react';
import {create} from 'react-test-renderer'
import "@testing-library/jest-dom/extend-expect";
import SearchBar from './SearchBar'
import {render, fireEvent} from '@testing-library/react'

test('Testing the Search Bar input', () => {
    const handleChange = jest.fn()
    const { container } = render(<input type="text" onChange={handleChange} />)
    const input = container.firstChild
    fireEvent.change(input, { target: { value: 'a' } })
    expect(handleChange).toHaveBeenCalledTimes(1)
    expect(input.value).toBe('a')
})

test("Match the snapshot - SearchBar",() => {
    const input=create(<SearchBar />);
    expect(input.toJSON()).toMatchSnapshot();
})