fetch("http://localhost:8080/api/test")
    .then(response => response.text())
    .then(data => {
        console.log(data);
    });

    const cardList = [];
    const deckContainer = document.getElementById("deckContainer");

    document.getElementById("starterHand").addEventListener("click", () => {
         for (let i = 0; i < 5; i++) {

        fetch("http://localhost:8080/api/card")
            .then(response => response.json())
            .then(card => {

                cardList.push(card);

                console.log("Card received:", card);

                if (cardList.length === 5) {
                    console.log("Starter Hand:", cardList);
                }

            })
            .catch(error => {
                console.error("Error:", error);
            });
                console.log("Starter Hand:", cardList);
                buttonLabels.forEach(label => {
                    const button = document.createElement("button");
                    button.textContent = label;
                    button.addEventListener('click', () => {
                        console.log(`Button "${label}" was clicked!`);
                        handleButtonClick(label);
                    });
                    deckContainer.appendChild(button);
                });
    }
});