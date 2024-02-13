///////////////////////////////////////// Object Literal Syntax
/* const book1 = {
    title: "Nineteen Eighty-Four",
    author: "George Orwell",
    genre: "Dystopian Future",
    edition: 1,
    published: 1949
};
let bookGenre = `<h2>${book1.title}</h2>`;

console.log(book1);
console.log(book1.author);
document.querySelector('.container').insertAdjacentHTML('beforeend', bookGenre); */


////////////////////////////////////////// Object Prototype Constructor
/* const book2 = new Object();
book2.title = 'Nineteen Eighty-Four';
book2.author = 'George Orwell';
book2.genre = 'Dystopian Future';
book2.edition = 1;
book2.published = 1949;

console.log(book2);
console.log(book2.title);
let bookAuthor = `<h2>${book2.title}</h2>`;
document.querySelector('.container').insertAdjacentHTML('beforeend', bookAuthor); */

/////////////////////////////////////////// Constructor Function 
const Book = function (title, author, genre, edition, published) {
    this.title = title;
    this.author = author;
    this.genre = genre;
    this.edition = edition;
    this.published = published;

};

const order = new Book('Nineteen Eighty-Four','George Orwell','Dystopian Future',1, 1949 );
console.log(order);
console.log(order.published);

let bookPublish = `
<h2>Book Title:</h2>
    <p> ${order.title}</p>
<h2>Author:</h2>
    <p> ${order.author}</p>
<h2>Published Year:</h2>
    <p>${order.published}</p>
    `;
document.querySelector('.container').insertAdjacentHTML('beforeend', bookPublish);
console.log(bookPublish);