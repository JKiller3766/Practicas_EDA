package registers;

import dogs.Dog;
import dogs.DogID;
import dogs.DogPurpose;

import java.util.*;

public class DogRegisterImp implements DogRegister {
    Map<String, List<Dog>> mapDogs;

    public DogRegisterImp() {
        mapDogs = new HashMap<>();
    }

    @Override
    public boolean registerOwner(String owner) {

        if (!mapDogs.containsKey(owner)) {
            mapDogs.put(owner, new ArrayList<Dog>());
            return true;
        }

        return false;

    }

    @Override
    public boolean registerDog(String owner, Dog dog) {

        if (!mapDogs.containsKey(owner)) {
            throw new UnknownOwnerException("Owner not found");
        }

        for (Dog currentDog : mapDogs.get(owner)) {
            if (currentDog.equals(dog)) {
                return false;
            }
        }

        for (String currentOwner : mapDogs.keySet()) {
            for (Dog currentDog : mapDogs.get(currentOwner)) {
                if (currentDog.equals(dog)) {
                    throw new DifferentOwnerException();
                }
            }
        }
        mapDogs.get(owner).add(dog);
        return true;

    }

    @Override
    public String findOwner(DogID id) {
        for (String currentOwner : mapDogs.keySet()) {
            for (Dog currentDog : mapDogs.get(currentOwner)) {
                if (currentDog.getId().equals(id)) {
                    return currentOwner;
                }
            }
        }
        return null;
    }

    @Override
    public SortedSet<Dog> registeredDogs(String owner) {
        SortedSet<Dog> dogs = new TreeSet<>();
        for (Dog currentDog : mapDogs.get(owner)) {
            if (currentDog != null) {
                dogs.add(currentDog);
            }
        }

        return dogs;

    }

    @Override
    public SortedSet<String> findPurposeOwners(DogPurpose purpose) {
        SortedSet<String> owners = new TreeSet<>();

        for (String currentOwner : mapDogs.keySet()) {
            for (Dog currentDog : mapDogs.get(currentOwner)) {
                if (currentDog.getType().equals(purpose)) {
                    owners.add(currentOwner);
                }
            }
        }

        return owners;
    }
}
