package persist.jdbc

import java.sql.ResultSet
import javax.inject.{Inject, Singleton}

import entity.ScenarioEntity

import org.joda.time.DateTime
import persist.ScenarioPersist
import play.api.db.Database

@Singleton
class ScenarioJdbc @Inject()(db: Database) extends ScenarioPersist {

  def find(id: Long): Option[ScenarioEntity] = db.withConnection { implicit conn =>
    val pstmt = conn.prepareStatement(FIND_BY_ID)
    pstmt.setLong(1, id)

    val rs = pstmt.executeQuery

    rs.next match {
      case true => Some(mapper(rs))
      case false => None
    }
  }

  def findAll() : List[ScenarioEntity] = db.withConnection { implicit conn =>
    val pstmt = conn.prepareStatement(FIND_ALL)

    val rs = pstmt.executeQuery

    new Iterator[ScenarioEntity] {
      override def hasNext = rs.next()
      override def next() = mapper(rs)
    }.toList
  }


  private def mapper(rs: ResultSet) = ScenarioEntity(
    id = rs.getLong("id")
    , name = rs.getString("name")
    , story = rs.getString("story")
    , enabled = rs.getBoolean("enabled")
    , customerId = 0
    , created = new DateTime("2016-10-23")
    , updated = new DateTime("2016-10-23"))

  private val FIND_BY_ID = "SELECT * FROM scenario WHERE id = ?"

  private val FIND_ALL = "SELECT * FROM scenario WHERE enabled = true"

}

