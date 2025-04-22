import {render, screen} from "@testing-library/react";
import {describe, it, expect, beforeEach} from "vitest";
import {UserCard} from "../components/UserCard.tsx";
import {userEvent} from "@testing-library/user-event";

describe('UserCard', () => {

    const testCard = {
        email: "name@email.com",
        name: "First M. Last",
        address: "123 ABC St.",
        city: "Fakeville",
        state: "Ohio",
        phoneNum: "757-123-4567"
    }

    beforeEach(() => {
    })

    it('Should display a card with an image, address, city, state, street, email, and phone number', async () => {
        //

        // Act
        render(<UserCard cardInfo={testCard}/>)

        // Assert
        expect(screen.getByRole("img")).toBeVisible();
        expect(screen.getByText(/Phone*/i)).toBeVisible();
        expect(screen.getByText(/State: */i)).toBeVisible()
        expect(screen.getByRole("button")).toBeVisible();
        screen.logTestingPlaygroundURL();

    })

    it('Should display edit options on button click', async () => {
        // Arrange
        render(<UserCard cardInfo={testCard} />)

        // Act
        const button = screen.getAllByRole("button")[0];
        const notMyForm = screen.queryByTitle("userForm");

        // Assert form invisible.
        expect(notMyForm).toBeNull;

        // Click button
        await userEvent.click(button)

        const myForm = await screen.findByTitle("userForm")

        // Assert form now visible
        expect(myForm).toBeVisible()

        // Print playground
        screen.logTestingPlaygroundURL();
    })

    it('Should render a user photo', () => {

    })
})