package dogapi;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * {
 *   "message": [
 *     "afghan",
 *     "basset",
 *     "blood",
 *     "english",
 *     "ibizan",
 *     "plott",
 *     "walker"
 *   ],
 *   "status": "success"
 * }
 *  the url for making the call would be "https://dog.ceo/api/breed/{breed}/list"
 *  */

class DogApiBreedFetcherTest {

    @Test
    void testValidBreedReturnsSubBreeds() throws BreedFetcher.BreedNotFoundException {
        BreedFetcher fetcher = new DogApiBreedFetcher();
        List<String> subBreeds = fetcher.getSubBreeds("hound");
        Set<String> expected = new HashSet<>(List.of("afghan", "basset", "blood", "english", "ibizan", "plott", "walker"));
        assertEquals(expected, new HashSet<>(subBreeds));
    }

    @Test
    void testInvalidBreedThrowsException() {
        BreedFetcher fetcher = new DogApiBreedFetcher();
        assertThrows(BreedFetcher.BreedNotFoundException.class, () -> fetcher.getSubBreeds("cat"));
    }
}