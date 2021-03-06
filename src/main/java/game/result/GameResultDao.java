package game.result;

import com.google.inject.persist.Transactional;
import util.jpa.GenericJpaDao;

import java.util.List;

/**
 * DAO class for the {@link GameResult} entity.
 */
public class GameResultDao extends GenericJpaDao<GameResult> {

    public GameResultDao() {
        super(GameResult.class);
    }

    /**
     * Returns the list of {@code n} latest results
     * for solving the puzzle.
     *
     * @param n the maximum number of results to be returned
     * @return the list of {@code n} latest results
     * for solving the puzzle.
     */
    @Transactional
    public List<GameResult> findBest(int n) {
        return entityManager.createQuery("SELECT r FROM GameResult r WHERE r.solved = true ORDER BY r.created DESC, r.duration ASC", GameResult.class)
                .setMaxResults(n)
                .getResultList();
    }

}

