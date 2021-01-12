const express = require("express");
const app = express();
const ejs = require("ejs");
const path = require("path")

app.set("view engine", "ejs")
app.set('views', path.join(__dirname, '/views'));

app.get("/students", (request, response) => {
    response.render("students/list", { title: "Manage Students" })
});

app.listen(3000, () => console.log("listening on port 3000"));