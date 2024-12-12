/** @type {import('tailwindcss').Config} */
import colors from "tailwindcss/colors";

export const content = ["./src/**/*.{js,jsx,ts,tsx}"];
export const theme = {
  fontFamily: {
    sans: ["Poppins"],
  },
  extend: {
    colors: {
      primary: colors.slate,
    },
  },
};
export const plugins = [];
