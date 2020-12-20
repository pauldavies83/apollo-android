// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.root_query_fragment_with_nested_fragments

import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.OperationName
import com.apollographql.apollo.api.Query
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.api.ScalarTypeAdapters
import com.apollographql.apollo.api.ScalarTypeAdapters.Companion.DEFAULT
import com.apollographql.apollo.api.internal.OperationRequestBodyComposer
import com.apollographql.apollo.api.internal.QueryDocumentMinifier
import com.apollographql.apollo.api.internal.ResponseFieldMapper
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller
import com.apollographql.apollo.api.internal.SimpleOperationResponseParser
import com.apollographql.apollo.api.internal.Throws
import com.example.root_query_fragment_with_nested_fragments.adapter.TestQuery_ResponseAdapter
import com.example.root_query_fragment_with_nested_fragments.fragment.DroidFragment
import com.example.root_query_fragment_with_nested_fragments.fragment.HeroFragment
import com.example.root_query_fragment_with_nested_fragments.fragment.QueryFragment
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress
import okio.Buffer
import okio.BufferedSource
import okio.ByteString
import okio.IOException

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
class TestQuery : Query<TestQuery.Data, Operation.Variables> {
  override fun operationId(): String = OPERATION_ID

  override fun queryDocument(): String = QUERY_DOCUMENT

  override fun variables(): Operation.Variables = Operation.EMPTY_VARIABLES

  override fun name(): OperationName = OPERATION_NAME

  override fun responseFieldMapper(): ResponseFieldMapper<Data> {
    return ResponseFieldMapper { reader ->
      TestQuery_ResponseAdapter.fromResponse(reader)
    }
  }

  @Throws(IOException::class)
  override fun parse(source: BufferedSource, scalarTypeAdapters: ScalarTypeAdapters):
      Response<Data> {
    return SimpleOperationResponseParser.parse(source, this, scalarTypeAdapters)
  }

  @Throws(IOException::class)
  override fun parse(byteString: ByteString, scalarTypeAdapters: ScalarTypeAdapters):
      Response<Data> {
    return parse(Buffer().write(byteString), scalarTypeAdapters)
  }

  @Throws(IOException::class)
  override fun parse(source: BufferedSource): Response<Data> {
    return parse(source, DEFAULT)
  }

  @Throws(IOException::class)
  override fun parse(byteString: ByteString): Response<Data> {
    return parse(byteString, DEFAULT)
  }

  override fun composeRequestBody(scalarTypeAdapters: ScalarTypeAdapters): ByteString {
    return OperationRequestBodyComposer.compose(
      operation = this,
      autoPersistQueries = false,
      withQueryDocument = true,
      scalarTypeAdapters = scalarTypeAdapters
    )
  }

  override fun composeRequestBody(): ByteString = OperationRequestBodyComposer.compose(
    operation = this,
    autoPersistQueries = false,
    withQueryDocument = true,
    scalarTypeAdapters = DEFAULT
  )

  override fun composeRequestBody(
    autoPersistQueries: Boolean,
    withQueryDocument: Boolean,
    scalarTypeAdapters: ScalarTypeAdapters
  ): ByteString = OperationRequestBodyComposer.compose(
    operation = this,
    autoPersistQueries = autoPersistQueries,
    withQueryDocument = withQueryDocument,
    scalarTypeAdapters = scalarTypeAdapters
  )

  /**
   * The query type, represents all of the entry points into our object graph
   */
  interface Data : Operation.Data {
    val __typename: String

    override fun marshaller(): ResponseFieldMarshaller

    interface Query : Data, QueryFragment {
      override val __typename: String

      override val hero: Hero?

      override val droid: Droid?

      override val human: Human?

      override fun marshaller(): ResponseFieldMarshaller

      /**
       * A character from the Star Wars universe
       */
      interface Hero : QueryFragment.Hero {
        override val __typename: String

        override fun marshaller(): ResponseFieldMarshaller

        interface Character : Hero, HeroFragment, QueryFragment.Hero.Character {
          override val __typename: String

          /**
           * The name of the character
           */
          override val name: String

          override fun marshaller(): ResponseFieldMarshaller
        }

        companion object {
          fun Hero.asCharacter(): Character? = this as? Character

          fun Hero.heroFragment(): HeroFragment? = this as? HeroFragment
        }
      }

      /**
       * An autonomous mechanical character in the Star Wars universe
       */
      interface Droid : QueryFragment.Droid {
        override val __typename: String

        override fun marshaller(): ResponseFieldMarshaller

        interface Droid : Query.Droid, DroidFragment, QueryFragment.Droid.Droid {
          override val __typename: String

          /**
           * What others call this droid
           */
          override val name: String

          /**
           * This droid's primary function
           */
          override val primaryFunction: String?

          override fun marshaller(): ResponseFieldMarshaller
        }

        companion object {
          fun Query.Droid.asDroid(): Droid? = this as? Droid

          fun Query.Droid.droidFragment(): DroidFragment? = this as? DroidFragment
        }
      }

      /**
       * A humanoid creature from the Star Wars universe
       */
      interface Human : QueryFragment.Human {
        override val __typename: String

        override fun marshaller(): ResponseFieldMarshaller

        interface Human : Query.Human, QueryFragment.Human.Human {
          override val __typename: String

          /**
           * What this human calls themselves
           */
          override val name: String

          /**
           * The home planet of the human, or null if unknown
           */
          override val homePlanet: String?

          override fun marshaller(): ResponseFieldMarshaller
        }

        companion object {
          fun Query.Human.asHuman(): Human? = this as? Human
        }
      }
    }

    data class QueryDatum(
      override val __typename: String,
      override val hero: Hero?,
      override val droid: Droid?,
      override val human: Human?
    ) : Data, Query, QueryFragment {
      override fun marshaller(): ResponseFieldMarshaller {
        return ResponseFieldMarshaller { writer ->
          TestQuery_ResponseAdapter.Data.QueryDatum.toResponse(writer, this)
        }
      }

      /**
       * A character from the Star Wars universe
       */
      interface Hero : Query.Hero, QueryFragment.Hero {
        override val __typename: String

        override fun marshaller(): ResponseFieldMarshaller

        interface Character : Query.Hero, Query.Hero.Character, HeroFragment,
            QueryFragment.Hero.Character {
          override val __typename: String

          /**
           * The name of the character
           */
          override val name: String

          override fun marshaller(): ResponseFieldMarshaller
        }

        data class CharacterHero(
          override val __typename: String,
          /**
           * The name of the character
           */
          override val name: String
        ) : Query.Hero, Query.Hero.Character, HeroFragment, QueryFragment.Hero.Character, Character,
            Hero {
          override fun marshaller(): ResponseFieldMarshaller {
            return ResponseFieldMarshaller { writer ->
              TestQuery_ResponseAdapter.Data.QueryDatum.Hero.CharacterHero.toResponse(writer, this)
            }
          }
        }

        data class OtherHero(
          override val __typename: String
        ) : Query.Hero, QueryFragment.Hero, Hero {
          override fun marshaller(): ResponseFieldMarshaller {
            return ResponseFieldMarshaller { writer ->
              TestQuery_ResponseAdapter.Data.QueryDatum.Hero.OtherHero.toResponse(writer, this)
            }
          }
        }

        companion object {
          fun Hero.asHero(): Query.Hero? = this as? Query.Hero

          fun Hero.asCharacter(): Character? = this as? Character

          fun Hero.heroFragment(): HeroFragment? = this as? HeroFragment
        }
      }

      /**
       * An autonomous mechanical character in the Star Wars universe
       */
      interface Droid : Query.Droid, QueryFragment.Droid {
        override val __typename: String

        override fun marshaller(): ResponseFieldMarshaller

        interface Droid : Query.Droid, Query.Droid.Droid, DroidFragment, QueryFragment.Droid.Droid {
          override val __typename: String

          /**
           * What others call this droid
           */
          override val name: String

          /**
           * This droid's primary function
           */
          override val primaryFunction: String?

          override fun marshaller(): ResponseFieldMarshaller
        }

        data class DroidDroid(
          override val __typename: String,
          /**
           * What others call this droid
           */
          override val name: String,
          /**
           * This droid's primary function
           */
          override val primaryFunction: String?
        ) : Query.Droid, Query.Droid.Droid, DroidFragment, QueryFragment.Droid.Droid, Droid,
            QueryDatum.Droid {
          override fun marshaller(): ResponseFieldMarshaller {
            return ResponseFieldMarshaller { writer ->
              TestQuery_ResponseAdapter.Data.QueryDatum.Droid.DroidDroid.toResponse(writer, this)
            }
          }
        }

        data class OtherDroid(
          override val __typename: String
        ) : Query.Droid, QueryFragment.Droid, QueryDatum.Droid {
          override fun marshaller(): ResponseFieldMarshaller {
            return ResponseFieldMarshaller { writer ->
              TestQuery_ResponseAdapter.Data.QueryDatum.Droid.OtherDroid.toResponse(writer, this)
            }
          }
        }

        companion object {
          fun QueryDatum.Droid.asDroid(): Droid? = this as? Droid

          fun QueryDatum.Droid.droidFragment(): DroidFragment? = this as? DroidFragment
        }
      }

      /**
       * A humanoid creature from the Star Wars universe
       */
      interface Human : Query.Human, QueryFragment.Human {
        override val __typename: String

        override fun marshaller(): ResponseFieldMarshaller

        interface Human : Query.Human, Query.Human.Human, QueryFragment.Human.Human {
          override val __typename: String

          /**
           * What this human calls themselves
           */
          override val name: String

          /**
           * The home planet of the human, or null if unknown
           */
          override val homePlanet: String?

          override fun marshaller(): ResponseFieldMarshaller
        }

        data class HumanHuman(
          override val __typename: String,
          /**
           * What this human calls themselves
           */
          override val name: String,
          /**
           * The home planet of the human, or null if unknown
           */
          override val homePlanet: String?
        ) : Query.Human, Query.Human.Human, QueryFragment.Human.Human, Human, QueryDatum.Human {
          override fun marshaller(): ResponseFieldMarshaller {
            return ResponseFieldMarshaller { writer ->
              TestQuery_ResponseAdapter.Data.QueryDatum.Human.HumanHuman.toResponse(writer, this)
            }
          }
        }

        data class OtherHuman(
          override val __typename: String
        ) : Query.Human, QueryFragment.Human, QueryDatum.Human {
          override fun marshaller(): ResponseFieldMarshaller {
            return ResponseFieldMarshaller { writer ->
              TestQuery_ResponseAdapter.Data.QueryDatum.Human.OtherHuman.toResponse(writer, this)
            }
          }
        }

        companion object {
          fun QueryDatum.Human.asHuman(): Human? = this as? Human
        }
      }
    }

    data class OtherDatum(
      override val __typename: String
    ) : Data {
      override fun marshaller(): ResponseFieldMarshaller {
        return ResponseFieldMarshaller { writer ->
          TestQuery_ResponseAdapter.Data.OtherDatum.toResponse(writer, this)
        }
      }
    }

    companion object {
      fun Data.asQuery(): Query? = this as? Query

      fun Data.queryFragment(): QueryFragment? = this as? QueryFragment
    }
  }

  companion object {
    const val OPERATION_ID: String =
        "a9a2dda27867aae4e7ec4ee3ed20374db9e0ac14f565cd293b397f8aa5580f1e"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |query TestQuery {
          |  __typename
          |  ...QueryFragment
          |}
          |fragment QueryFragment on Query {
          |  __typename
          |  hero {
          |    __typename
          |    ...heroFragment
          |  }
          |  droid(id: 1) {
          |    __typename
          |    ...droidFragment
          |  }
          |  human(id: 1) {
          |    __typename
          |    ... on Human {
          |      name
          |      homePlanet
          |    }
          |  }
          |}
          |fragment heroFragment on Character {
          |  __typename
          |  name
          |}
          |fragment droidFragment on Droid {
          |  __typename
          |  name
          |  primaryFunction
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: OperationName = object : OperationName {
      override fun name(): String {
        return "TestQuery"
      }
    }
  }
}