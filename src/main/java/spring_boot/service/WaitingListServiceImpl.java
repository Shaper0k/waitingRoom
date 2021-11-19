package spring_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import spring_boot.dao.WaitingListRepository;
import spring_boot.entity.WaitingList;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WaitingListServiceImpl implements WaitingListService {

    private final WaitingListRepository WaitingListRepository;

    public WaitingListServiceImpl(WaitingListRepository WaitingListRepository) {
        this.WaitingListRepository = WaitingListRepository;
    }

    @Override
    public void addEntry(WaitingList waitingList) {
        WaitingListRepository.save(waitingList);
    }

    @Override
    public void updateEntry(WaitingList waitingList) {
        WaitingListRepository.save(waitingList);
    }

    @Override
    public void removeEntryById(long id) {
        WaitingListRepository.deleteById(id);
    }

    @Override
    public Optional<WaitingList> getEntryById(long id) {
        return WaitingListRepository.findById(id);
    }

    @Override
    public List<WaitingList> getAllEntry() {
        return WaitingListRepository.findAll();
    }


}
