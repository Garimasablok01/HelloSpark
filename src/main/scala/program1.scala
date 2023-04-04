import org.apache.spark.sql.types.DataType
import org.apache.spark.sql.{DataFrame, SaveMode, SparkSession}

import scala.Console.println
import scala.reflect.io.Path

object program1 {

  def main(args:Array[String]):Unit= {

    val spark = SparkSession.builder()
      .appName("count")
      .master("local[3]")
      .getOrCreate()

    val countDf = spark.read
      .format("csv")
      .option("Header", "True")
      .option("mode", "FAILFAST")
      .load("Program1")
    countDf.show(false)
    countDf.count()
    println(countDf.count())


    countRead(spark,"Program1").show()

    /* countDf.write
      .format("json")
      .mode(SaveMode.Overwrite)
      .option("path","Program1/output")
      .save()
      //countDf.repartition(2).write.json("Program1/output")*/


    def countRead(spark: SparkSession, path: String): DataFrame={
    spark.read.csv(path)
    }

  }
}


