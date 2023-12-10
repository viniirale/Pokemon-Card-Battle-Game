 async function fillPokemonSelects() {
    const select1 = document.getElementById('pokemonSelect1');
    const select2 = document.getElementById('pokemonSelect2');
    
    for (let id = 1; id <= 809; id++) {
        const info = await fetchPokemonInfo(id);
        const option = document.createElement('option');
        option.value = id;
        option.text = `${id} - ${info.name.english}`;
        select1.add(option.cloneNode(true));
        select2.add(option.cloneNode(true));
    }
}


function clearBattle() {
    document.getElementById('pokemonCard1').innerHTML = '';
    document.getElementById('pokemonCard2').innerHTML = '';
    document.getElementById('result').innerText = '';
}

async function fetchPokemonInfo(id) {
    const response = await fetch(`/pokemon/info/${id}`);
    const data = await response.json();
    return data;
}

async function fetchPokemonSprite(id) {
    const response = await fetch(`/pokemon/image/${id}`);
    if (response.ok) {
        return response.blob();
    } else {
        throw new Error('Pokemon sprite not found');
    }
}

async function loadPokemonCard(cardId, pokemonId) {
    const formattedPokemonId = String(pokemonId).padStart(3, '0');

    try {
        const info = await fetchPokemonInfo(formattedPokemonId);
        const sprite = await fetchPokemonSprite(formattedPokemonId);

        const card = document.getElementById(cardId);
        card.innerHTML = `
            <h3>${info.name.english}</h3>
            <img src="${URL.createObjectURL(sprite)}" alt="Pokemon Image">
            <p>HP: ${info.base.HP}</p>
            <p>Attack: ${info.base.Attack}</p>
            <p>Defense: ${info.base.Defense}</p>
            <!-- Add other stats as needed -->
        `;

        return info.base; 
    } catch (error) {
        console.error(error);
        alert(`Error loading Pokémon with ID: ${formattedPokemonId}. Please try again.`);
        throw error; 
    }
}

async function startGame() {
    const pokemonId1 = document.getElementById('pokemonSelect1').value;
    const pokemonId2 = document.getElementById('pokemonSelect2').value;

    if (!pokemonId1 || !pokemonId2) {
        alert('Please select both Pokémon!');
        return;
    }

    try {
        const [baseStats1, baseStats2] = await Promise.all([
            loadPokemonCard('pokemonCard1', pokemonId1),
            loadPokemonCard('pokemonCard2', pokemonId2)
        ]);

        const resultElement = document.getElementById('result');
        if (baseStats1.HP + baseStats1.Attack + baseStats1.Defense >
            baseStats2.HP + baseStats2.Attack + baseStats2.Defense) {
            resultElement.innerText = 'Pokemon 1 wins!';
        } else if (baseStats2.HP + baseStats2.Attack + baseStats2.Defense >
            baseStats1.HP + baseStats1.Attack + baseStats1.Defense) {
            resultElement.innerText = 'Pokemon 2 wins!';
        } else {
            resultElement.innerText = 'It\'s a tie!';
        }
    } catch (error) {
        console.error(error);
        alert('An error occurred. Please try again.');
    }
}

    document.addEventListener('DOMContentLoaded', fillPokemonSelects);
    
    
    
    