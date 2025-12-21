class BookRepository {
    function save(Book $book) {
        $filename = '/documents/' . $book->getTitle();
        file_put_contents($filename, serialize($book));
    }
}
