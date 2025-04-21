import {render, screen} from "@testing-library/react";
import {describe, it, expect} from "vitest";
import {UserCard} from "../components/UserCard.tsx";
import {userEvent} from "@testing-library/user-event";

describe('UserCard', () => {
    it('Should display a card with a form field', () => {
        //

        // Act
        render(<UserCard/>)

        // Assert
        expect(screen.getByText(/Name/i)).toBeVisible();
        expect(screen.getByLabelText(/State/i)).toBeVisible()
        expect(screen.getByRole("button")).toBeVisible();
    })

    it('Should display edit options on button click', () => {
        //

        const checkbox = screen.getByRole
        // Act
        render(<UserCard/>)
        userEvent.click()

        // Assert
    })
})